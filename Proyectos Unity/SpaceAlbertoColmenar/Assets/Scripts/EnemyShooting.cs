using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyShooting : MonoBehaviour
{
    Transform player;
    public GameObject bulletPrefab;
    public float fireDelay = 0.5f;
    float cooldownTimer = 0;

    void Update()
    {
        if (player == null)
        {
            GameObject go = GameObject.Find("Player");

            if (go != null)
            {
                player = go.transform;
            }
        }

        if (player == null)
            return;

        Vector3 dir = player.position - transform.position;
        dir.Normalize();

        float zAngle = Mathf.Atan2(dir.y, dir.x) * Mathf.Rad2Deg - 90;
        transform.GetChild(0).rotation = Quaternion.Euler(0, 0, zAngle);

        cooldownTimer -= Time.deltaTime;
        if (cooldownTimer <= 0)
        {
            cooldownTimer = fireDelay;

            Instantiate(bulletPrefab, transform.GetChild(0).position, transform.GetChild(0).rotation);
        }
    }
}
